package com.joe.ssl.crypto;

/**
 * HMAC��Keyed-Hashing for Message Authentication���㷨�ӿڣ���Ϣ�����Ա�֤����֤��Ϣ���ᱻ�۸ģ��㷨������£�
 * <br/>
 * <br/>
 * <p>
 *      ipad = the byte 0x36 repeated B times <br/>
 *      opad = the byte 0x5C repeated B times.<br/><br/>
 *
 *      ������text��mac���㣨H��ʾhash�㷨��������MD5��Ҳ������SHA�ȣ�K��ʾ��Կ��ͨ��˫����Ӧ���У���<br/>
 *      H(K XOR opad, H(K XOR ipad, text))
 * </p>
 * <br/>
 * <br/>
 * <p>
 *     HMAC�㷨ǰ����ͨ��˫����һ����ͬ����Կ���൱��salt����ֻ�ܱ�֤��Ϣ�����ԣ����ǲ��߱�����ǩ���Ŀ������ԣ�Ҳ����A����B��Ϣ��A����
 *     ���Ϸ��������Ϣ����Ϊ�����õ���Կ˫�����У�B���Ժ�������һ��ͬ������Ϣ������
 * </p>
 * <br/>
 * ����ĵ����Բο���https://tools.ietf.org/html/rfc2104
 *
 * <p>
 *     ���̰߳�ȫ
 * </p>
 * @author JoeKerouac
 * @version 2020��07��23�� 15:34
 */
public interface HmacSpi extends AlgorithmSpi {

    /**
     * ��ʼ��
     *
     * @param key �Գ���Կ
     */
    void init(byte[] key);

    /**
     * ��������
     *
     * @param data Դ����
     */
    void update(byte[] data);

    /**
     * ������Դ���ݽ���hmac��֤����
     * @return ��֤����
     */
    byte[] doFinal();

    /**
     * ��ָ������������֤����
     * @param data ����
     * @return ��֤����
     */
    default byte[] doFinal(byte[] data) {
        update(data);
        return doFinal();
    }

    /**
     * �����ڴ��е���֤���ݣ�����������֤
     */
    void reset();

    /**
     * hash�㷨��
     * @return hash�㷨��
     */
    String hashAlgorithm();
}
