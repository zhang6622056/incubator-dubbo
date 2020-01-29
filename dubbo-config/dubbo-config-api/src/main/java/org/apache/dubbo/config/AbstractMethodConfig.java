/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.config;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.cluster.LoadBalance;

import java.util.Map;

/**
 * AbstractMethodConfig
 *
 * @export
 */
public abstract class AbstractMethodConfig extends AbstractConfig {

    private static final long serialVersionUID = 1L;

    /**
     * The timeout for remote invocation in milliseconds
     *
     */
    protected Integer timeout;

    /**
     * 调用重试次数
     * The retry times
     */
    protected Integer retries;

    /**
     * 最高并发调用的请求数
     * max concurrent invocations
     */
    protected Integer actives;

    /**
     * 负载均衡策略
     * The load balance
     */
    protected String loadbalance;

    /**
     * 是否开启异步调用，指reference配置，异步调用不关心返回值，但是异步调用并不可靠
     * Whether to async
     * note that: it is an unreliable asynchronism that ignores return values and does not block threads.
     */
    protected Boolean async;

    /**
     * 异步调用情况下，是否开启调用确认 TODO-ZL 需要验证实现
     * Whether to ack async-sent
     */
    protected Boolean sent;

    /**
     * 如果打开为true，则查找接口名+Mock的实现，作为备用实现
     *
     * The name of mock class which gets called when a service fails to execute
     *
     * note that: the mock doesn't support on the provider side，and the mock is executed when a non-business exception
     * occurs after a remote service call
     */
    protected String mock;

    /**
     * Merger
     * 用于分组聚合，搭配group使用
     * http://dubbo.apache.org/zh-cn/docs/user/demos/group-merger.html
     */
    protected String merger;

    /**
     * Cache the return result with the call parameter as key, the following options are available: lru, threadlocal,
     * jcache, etc.
     * 本地缓存，需要考虑分布式一致性问题
     * 以调用参数为key，缓存返回结果，可选：lru, threadlocal, jcache等
     */
    protected String cache;

    /**
     * Whether JSR303 standard annotation validation is enabled or not, if enabled, annotations on method parameters will
     * be validated
     * TODO-ZL 待理解
     */
    protected String validation;

    /**
     * The customized parameters
     */
    protected Map<String, String> parameters;

    /**
     * Forks for forking cluster
     * TODO-ZL 待理解
     */
    protected Integer forks;






    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        checkExtension(LoadBalance.class, Constants.LOADBALANCE_KEY, loadbalance);
        this.loadbalance = loadbalance;
    }

    public Boolean isAsync() {
        return async;
    }

    public void setAsync(Boolean async) {
        this.async = async;
    }

    public Integer getActives() {
        return actives;
    }

    public void setActives(Integer actives) {
        this.actives = actives;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    @Parameter(escaped = true)
    public String getMock() {
        return mock;
    }

    public void setMock(String mock) {
        if (mock == null) {
            return;
        }

        if (mock.startsWith(Constants.RETURN_PREFIX) || mock.startsWith(Constants.THROW_PREFIX + " ")) {
            checkLength(Constants.MOCK_KEY, mock);
        } else if (mock.startsWith(Constants.FAIL_PREFIX) || mock.startsWith(Constants.FORCE_PREFIX)) {
            checkNameHasSymbol(Constants.MOCK_KEY, mock);
        } else {
            checkName(Constants.MOCK_KEY, mock);
        }
        this.mock = mock;
    }

    public void setMock(Boolean mock) {
        if (mock == null) {
            setMock((String) null);
        } else {
            setMock(String.valueOf(mock));
        }
    }

    public String getMerger() {
        return merger;
    }

    public void setMerger(String merger) {
        this.merger = merger;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        checkParameterName(parameters);
        this.parameters = parameters;
    }

}
