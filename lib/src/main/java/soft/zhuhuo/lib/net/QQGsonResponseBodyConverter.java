package soft.zhuhuo.lib.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLDecoder;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class QQGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    QQGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        String responseUTF_8 = URLDecoder.decode(value.string(), "UTF-8");
        return gson.fromJson(responseUTF_8, type);
//        return ()responseUTF_8;
//        Type mBaseResultType = $Gson$Types.newParameterizedTypeWithOwner(null, BaseResult.class, type);
//        BaseResult mBaseBean = gson.fromJson(responseUTF_8, mBaseResultType);
//
//        if (mBaseBean.getCode() == 200) {
//            return (T) mBaseBean.getRetData();
//        } else if (mBaseBean.getCode() == -400) {
//            throw new QQManagerException(-400);
//        } else {
//            throw new IllegalStateException(mBaseBean.getMsg());
//        }
    }
}