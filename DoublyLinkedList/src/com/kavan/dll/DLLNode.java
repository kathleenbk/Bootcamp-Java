package com.kavan.dll;

public class DLLNode {
	public Integer value;
    public DLLNode previous;
    public DLLNode next;
    
    public DLLNode(Integer val) {
        this.value = val;
        this.previous = null;
        this.next = null;
    }
}