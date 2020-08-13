package com.ly.springcloudlytemplate.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author luoYong
 * @create 2020/8/13 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult  implements Serializable {

    private static final long serialVersionUID = 1L;

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    // 响应消息
    private String  msg;

    // 响应中的数据
    private Object  data;

    public CommonResult(Object data) {
        this.status = 200;
        this.msg = "操作成功";
        this.data = data;
    }

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }

    public static CommonResult build(Integer status, String msg, Object data) {
        return new CommonResult(status, msg, data);
    }

    public static CommonResult ok(Object data) {
        return new CommonResult(data);
    }

    public static CommonResult ok() {
        return new CommonResult(null);
    }

    public static CommonResult fail() {
        return new CommonResult(400, "操作失败", null);
    }

    public static CommonResult fail(String msg) {
        return new CommonResult(400, msg, null);
    }

    public static CommonResult build(Integer status, String msg) {
        return new CommonResult(status, msg, null);
    }

    /**
     * 将json结果集转化为BroadcastResult对象
     *
     * @param jsonData json数据
     * @param clazz    BroadcastResult中的object类型
     * @return
     */
    public static CommonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, CommonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static CommonResult format(String json) {
        try {
            return MAPPER.readValue(json, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static CommonResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
