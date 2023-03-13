package com.example.budgettracker.model;

public class expenseModel {
    String id, amount, type, note, date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public expenseModel() {
    }

    public expenseModel(String id, String amount, String type, String note, String date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.note = note;
        this.date = date;
    }
}
