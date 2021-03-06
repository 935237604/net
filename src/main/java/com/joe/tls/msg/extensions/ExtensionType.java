package com.joe.tls.msg.extensions;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;

/**
 * @author JoeKerouac
 * @version 2020年06月13日 16:46
 */
@EqualsAndHashCode
public class ExtensionType {
    final int id;
    final String name;

    private ExtensionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    static List<ExtensionType> knownExtensions = new ArrayList<ExtensionType>(14);

    /**
     * 根据扩展id获取类型
     * 
     * @param id
     *            扩展id
     * @return 扩展类型
     */
    public static ExtensionType get(int id) {
        for (ExtensionType ext : knownExtensions) {
            if (ext.id == id) {
                return ext;
            }
        }
        return new ExtensionType(id, "type_" + id);
    }

    private static ExtensionType e(int id, String name) {
        ExtensionType ext = new ExtensionType(id, name);
        knownExtensions.add(ext);
        return ext;
    }

    // extensions defined in RFC 3546
    public final static ExtensionType EXT_SERVER_NAME = e(0x0000, "server_name"); // IANA registry value: 0
    public final static ExtensionType EXT_MAX_FRAGMENT_LENGTH = e(0x0001, "max_fragment_length"); // IANA registry
                                                                                                  // value: 1
    public final static ExtensionType EXT_CLIENT_CERTIFICATE_URL = e(0x0002, "client_certificate_url"); // IANA registry
                                                                                                        // value: 2
    public final static ExtensionType EXT_TRUSTED_CA_KEYS = e(0x0003, "trusted_ca_keys"); // IANA registry value: 3
    public final static ExtensionType EXT_TRUNCATED_HMAC = e(0x0004, "truncated_hmac"); // IANA registry value: 4
    public final static ExtensionType EXT_STATUS_REQUEST = e(0x0005, "status_request"); // IANA registry value: 5

    // extensions defined in RFC 4681
    public final static ExtensionType EXT_USER_MAPPING = e(0x0006, "user_mapping"); // IANA registry value: 6

    // extensions defined in RFC 5081
    public final static ExtensionType EXT_CERT_TYPE = e(0x0009, "cert_type"); // IANA registry value: 9

    // extensions defined in RFC 4492 (ECC)
    public final static ExtensionType EXT_ELLIPTIC_CURVES = e(0x000A, "elliptic_curves"); // IANA registry value: 10
    public final static ExtensionType EXT_EC_POINT_FORMATS = e(0x000B, "ec_point_formats"); // IANA registry value: 11

    // extensions defined in RFC 5054
    public final static ExtensionType EXT_SRP = e(0x000C, "srp"); // IANA registry value: 12

    // extensions defined in RFC 5246
    public final static ExtensionType EXT_SIGNATURE_ALGORITHMS = e(0x000D, "signature_algorithms"); // IANA registry
                                                                                                    // value: 13

    // extensions defined in RFC 7627
    public static final ExtensionType EXT_EXTENDED_MASTER_SECRET = e(0x0017, "extended_master_secret"); // IANA registry
                                                                                                        // value: 23

    // extensions defined in RFC 5746
    public final static ExtensionType EXT_RENEGOTIATION_INFO = e(0xff01, "renegotiation_info"); // IANA registry value:
                                                                                                // 65281
}
