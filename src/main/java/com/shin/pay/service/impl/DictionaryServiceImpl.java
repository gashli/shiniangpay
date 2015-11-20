package com.shin.pay.service.impl;

import com.shin.pay.service.DictionaryService;

import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public class DictionaryServiceImpl implements DictionaryService {
    private static final String split = ",";
    private static final String con_symbol = "_";

    private Map<String,String> resource = new Hashtable<String, String>();
    private Map<String,String> configs ;

    public String getValue(String type, String key) {

        if (resource.isEmpty()){
            init();
        }
        String value = resource.get(type+con_symbol+key);
        return null==value?key:value;
    }

    private void init(){
        if (null==configs){
            return;
        }
        for (String type:configs.keySet()){
            resolve(type,configs.get(type));
        }
    }


    private void resolve(String type,String datas){
        StringTokenizer st = new StringTokenizer(datas,split);
        while (st.hasMoreTokens()){
            resource.put(type+con_symbol+st.nextToken(),st.nextToken());
        }
    }
}
