package com.shin.pay.service;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public interface DictionaryService {

    String CHARACTERNAME = "characterName";

    String BUSITYPEID = "busiType";

    String MERCHANTCODE = "merchantCode";

    /**
     * type:字典类型
     * key:关键字
     * */
    public String getValue(String type,String key);

}
