package com.joe.ssl.message.extension;

import java.io.IOException;
import java.util.Arrays;

import com.joe.ssl.message.WrapedOutputStream;
import com.joe.utils.common.Assert;

/**
 * ECC椭圆曲线扩展
 *
 * @author JoeKerouac
 * @version 1.0
 * @date 2020-09-10 10:16
 */
public class EllipticCurvesExtension implements HelloExtension {

    private int[] curve;

    public EllipticCurvesExtension(int[] curve) {
        Assert.notNull(curve, "curve不能为null");
        this.curve = curve;
    }

    @Override
    public void write(WrapedOutputStream outputStream) throws IOException {
        outputStream.writeInt16(getExtensionType().id);
        outputStream.writeInt16(curve.length * 2 + 2);
        outputStream.writeInt16(curve.length * 2);
        for (int curveId : curve) {
            outputStream.writeInt16(curveId);
        }
    }

    @Override
    public ExtensionType getExtensionType() {
        return ExtensionType.EXT_ELLIPTIC_CURVES;
    }

    @Override
    public int size() {
        return curve.length * 2 + 2 + 4;
    }

    @Override
    public String toString() {
        return String.format("%s :\t[supports curve : %s]", getExtensionType().name,
            Arrays.toString(curve));
    }
}
