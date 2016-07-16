package com.expressway.billmanagement.report.api;

/**
 * 资源加载接口
 * 
 * @author Ajaxfan
 */
public interface IResourceLoader<T> {
    public T load(String resName);
}
