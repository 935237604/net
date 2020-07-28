package com.joe.ssl.crypto;

/**
 * ��ϢժҪSPI
 *
 * <p>
 *     ���̰߳�ȫ
 * </p>
 * @author JoeKerouac
 * @version 2020��07��23�� 14:46
 */
public interface DigestSpi extends AlgorithmSpi {

    /**
     * ��������
     *
     * @param data Դ����
     */
    void update(byte[] data);

    /**
     * ������Դ���ݽ���ժҪ
     * @return ժҪ���
     */
    byte[] digest();

    /**
     * ����ǰ�ڴ������ݵ�ժҪ�����ָ�����飬�������offset��������㹻�Ŀռ���ժҪ
     *
     * @param output �������
     * @param offset �����ʼλ�ã�����������ĸ�λ�ý�ժҪ������������
     */
    void digest(byte[] output, int offset);

    /**
     * ��ָ����������ժҪ
     * @param data ����
     * @return ժҪ
     */
    default byte[] digest(byte[] data) {
        update(data);
        return digest();
    }

    /**
     * ����ժҪ����������ժҪ
     */
    void reset();

    @Override
    default int type() {
        return AlgorithmSpi.DIGEST;
    }
}
