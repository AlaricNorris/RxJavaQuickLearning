package com.alaric.norris.study.retrofit.latest;
public class ApiInfo {
    private ApiInfoBean apiInfo;

    public ApiInfoBean getApiInfo () {
        return apiInfo;
    }

    public void setApiInfo ( ApiInfoBean apiInfo ) {
        this.apiInfo = apiInfo;
    }

    public class ApiInfoBean {
        private String apiName;
        private String apiKey;
        //省略get和set方法

        public String getApiName () {
            return apiName;
        }
        public void setApiName ( String inApiName ) {
            apiName = inApiName;
        }
        public String getApiKey () {
            return apiKey;
        }
        public void setApiKey ( String inApiKey ) {
            apiKey = inApiKey;
        }
    }
}