package com.qsn.spring.generator.common.enums;


import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.qsn.spring.common.enums.EnumItem;
import com.qsn.spring.common.enums.IEnum;
import org.apache.commons.lang.StringUtils;

/**
 * 自定义枚举
 * 概念： 枚举就是在一个类里定义几个静态变量，每个变量都是这个类的实例。
 * 枚举值本质上是静态常量。
 * 枚举这种特殊的类因为被修饰为 final，所以不能继承其他类。
 * 定义的枚举值，会被默认修饰为 public static final
 * <p>
 * 作用：就是提供常量
 * 好处：枚举是一种规范它规范了参数的形式，这样就可以不用考虑类型的不匹配
 * 场景：错误码、状态等
 *
 * @author qiusn
 * @version 1.0 2019/11/22 17:53
 */
public interface TestEnums {

    /**
     * 性别
     */
    enum USER_SEX implements IEnum<Integer> {

        SEX_MAN(1, "男"),
        SEX_WOMAN(2, "女"),
        SEX_LADY_BOY(3, "不男不女"),;


        private EnumItem<Integer> item;


        USER_SEX(int type, String name) {
            this.item = new EnumItem<>(type, name);
        }


        @Override
        public EnumItem<Integer> item() {
            return this.item;
        }

//        @Override
//        public String getValueByKey(int key){
//            for (USER_SEX s : USER_SEX.values()) {
//                if(s.item().getKey()==key){
//                    return s.item.getValue();
//                }
//            }
//            return "";
//        }
//
//        @Override
//        public int getKeyByValue(String value){
//            if(StringUtils.isBlank(value)){
//                throw new ApiException("value不能为空");
//            }
//            for (USER_SEX s : USER_SEX.values()) {
//                if(value.equals(s.item.getValue())){
//                    return s.item.getKey();
//                }
//            }
//            return 0;
//        }

        public static String getValueByKey(int key){
            for (USER_SEX s : USER_SEX.values()) {
                if(s.item().getKey()==key){
                    return s.item.getValue();
                }
            }
            return "";
        }

        public static int getKeyByValue(String value){
            if(StringUtils.isBlank(value)){
                throw new ApiException("value不能为空");
            }
            for (USER_SEX s : USER_SEX.values()) {
                if(value.equals(s.item.getValue())){
                    return s.item.getKey();
                }
            }
            return 0;
        }


    }

    public static void main(String[] args){
//        String value = TestEnums.USER_SEX.SEX_WOMAN.getValueByKey(3);

    }

















}
