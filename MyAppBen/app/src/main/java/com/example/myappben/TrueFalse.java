package com.example.myappben;

public class TrueFalse {
    private int name;
    private Boolean value;
    public TrueFalse(int name, Boolean value)
    {
        this.name=name;
        this.value=value;
    }
    public int getQuestion()
    {
        return this.name;
    }
    public boolean isResult()
    {
        return this.value;
    }
}
