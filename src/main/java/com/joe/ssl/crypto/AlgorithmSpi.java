package com.joe.ssl.crypto;

/**
 * �㷨�ӿڣ������㷨���̳��Ըýӿ�
 * 
 * @author JoeKerouac
 * @version 2020��07��23�� 16:00
 */
public interface AlgorithmSpi extends Cloneable {

    /**
     * ժҪ�㷨����
     */
    int DIGEST = 0;

    /**
     * �����㷨����
     */
    int CIPHER = 1;

    /**
     * Hmac�㷨����
     */
    int HMAC   = 2;

    /**
     * Phash�㷨����
     */
    int PHASH  = 3;

    /**
     * �㷨��
     * @return �㷨��
     */
    String name();

    /**
     * �㷨����
     * @return �㷨����
     */
    int type();

    /**
     * ��¡��Ĭ�ϲ�֧�֣�������ʵ��
     * @return ��¡���
     * @throws CloneNotSupportedException �쳣
     */
    default Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("��֧��clone����");
    }
}
