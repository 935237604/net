package com.joe.ssl.crypto;

/**
 * �㷨�ӿ�
 * 
 * @author JoeKerouac
 * @version 2020��07��23�� 16:00
 */
public interface AlgorithmSpi extends Cloneable {

    /**
     * �㷨��
     * @return �㷨��
     */
    String name();

    Object clone() throws CloneNotSupportedException;
}
