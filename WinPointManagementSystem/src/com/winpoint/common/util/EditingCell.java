package com.winpoint.common.util;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class EditingCell extends TableCell<ObservableList, String> {
    private TextField textField;
//    TableColumn<ObservableList, String> column;
    public EditingCell() {
    	
    }
//    public EditingCell(TableColumn<ObservableList, String> param) {
//    	this.column = param;
//    }
//    
//    public TableColumn<ObservableList, String> getColumn() {
//		return column;
//	}
//	public void setColumn(TableColumn<ObservableList, String> column) {
//		this.column = column;
//	}
	@Override
    public void startEdit() {
        super.startEdit();
        if (textField == null) {
            createTextField();
        }
        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
                textField.selectAll();
            }
        });
    }
    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText((String) getItem());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
        //setString(getString());
        //column.setCellValueFactory(c-> new SimpleStringProperty(getString()));
    }
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                   // column.setCellValueFactory(c-> new SimpleStringProperty(getString()));
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
            	//column.setCellValueFactory(c-> new SimpleStringProperty(getString()));
            	//setString(getString());
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }
    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                } else if (t.getCode() == KeyCode.TAB) {
                    commitEdit(textField.getText());
                    TableColumn nextColumn = getNextColumn(!t.isShiftDown());
                    if (nextColumn != null) {
                        getTableView().edit(getTableRow().getIndex(), nextColumn);
                    }
                }
            }
        });
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue && textField != null) {
                	setString(textField.getText());
                    commitEdit(textField.getText());
                }
            }
        });
    }
    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
    
    public void setString(String s) {
    	setItem(s);
    }
    /**
     *
     * @param forward true gets the column to the right, false the column to the left of the current column
     * @return
     */
    private TableColumn<ObservableList, ?> getNextColumn(boolean forward) {
        List<TableColumn<ObservableList, ?>> columns = new ArrayList<>();
        for (TableColumn<ObservableList, ?> column : getTableView().getColumns()) {
            columns.addAll(getLeaves(column));
        }
        //There is no other column that supports editing.
        if (columns.size() < 2) {
            return null;
        }
        int currentIndex = columns.indexOf(getTableColumn());
        int nextIndex = currentIndex;
        if (forward) {
            nextIndex++;
            if (nextIndex > columns.size() - 1) {
                nextIndex = 0;
            }
        } else {
            nextIndex--;
            if (nextIndex < 0) {
                nextIndex = columns.size() - 1;
            }
        }
        return columns.get(nextIndex);
    }
    
    private List<TableColumn<ObservableList, ?>> getLeaves(TableColumn<ObservableList, ?> root) {
        List<TableColumn<ObservableList, ?>> columns = new ArrayList<>();
        if (root.getColumns().isEmpty()) {
            //We only want the leaves that are editable.
            if (root.isEditable()) {
                columns.add(root);
            }
            return columns;
        } else {
            for (TableColumn<ObservableList, ?> column : root.getColumns()) {
                columns.addAll(getLeaves(column));
            }
            return columns;
        }
    }
}
