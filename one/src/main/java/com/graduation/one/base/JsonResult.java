package com.graduation.one.base;

import java.io.Serializable;

/**
 * Created by Yujn 19/3/15.
 *
 * @author indusfo.corp
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 1368407471638948451L;

    /**
     * 结果判断
     */
    private Boolean success;

    /**
     * 数据
     */
    private T data;

    /**
     * 消息
     */
    private String message;

    /**
     * 参数
     */
    private String code;

    /**
     * 数据量
     */
    private Integer count = 1;

    public JsonResult() {
        this.success = true;
        this.message = "";
    }

    public JsonResult(T data) {
        this.data = data;
        success = true;
    }

    public JsonResult(Boolean success) {
        this.success = success;
    }

    public JsonResult(String code, String message) {
        this.message = message;
        this.code = code;
        success = false;
    }

    public JsonResult(Boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public JsonResult(Boolean success, T data, String message) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public JsonResult(Boolean success, T data, String code, String message) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public JsonResult<T> success(String message) {
        this.setSuccess(true);
        this.setMessage(message);
        return this;
    }

    public JsonResult<T> success(String message, T data) {
        this.setSuccess(true);
        this.setMessage(message);
        this.setData(data);
        return this;
    }

    public JsonResult<T> success(String message, T data, Integer count) {
        this.count = count;
        this.setSuccess(true);
        this.setMessage(message);
        this.setData(data);
        return this;
    }

    public JsonResult<T> failure(String message) {
        this.setSuccess(false);
        this.setMessage(message);
        return this;
    }

    public JsonResult<T> failure(String message, T data) {
        this.setSuccess(false);
        this.setMessage(message);
        this.setData(data);
        return this;
    }

    public JsonResult<T> failure(String message, T data, Integer count) {
        this.count = count;
        this.setSuccess(false);
        this.setMessage(message);
        this.setData(data);
        return this;
    }

    public JsonResult<T> data(T t) {
        this.setData(t);
        return this;
    }

    public JsonResult<T> code(String code) {
        this.setCode(code);
        return this;
    }

    public JsonResult<T> successdata(T t) {
        this.data(t);
        this.success = true;
        return this;
    }

    public static JsonResult successMessage() {
        return JsonResult.successMessage("success");
    }

    public static JsonResult successMessage(String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(Boolean.TRUE);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult failureMessage(String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(Boolean.FALSE);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> successResult(T data) {
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setSuccess(Boolean.TRUE);
        jsonResult.setMessage("success");
        return jsonResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> successResult(String msg, T data) {
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setSuccess(Boolean.TRUE);
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> successResult(String msg, T data, Integer count) {
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setSuccess(Boolean.TRUE);
        jsonResult.setMessage(msg);
        jsonResult.setCount(count);
        return jsonResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> failResult(T data) {
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setSuccess(Boolean.FALSE);
        jsonResult.setMessage("fail");
        return jsonResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> failResult(String msg, T data) {
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setSuccess(Boolean.FALSE);
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    public static JsonResult failResponse(String message, String code) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage(message);
        jsonResult.setCode(code);

        return jsonResult;
    }

    public T getData() {
        return data;
    }

    public Integer getCount() {
        return count;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}