package jsontest;

import com.alibaba.fastjson.JSONObject;

public class TestJson {
    public static void main(String[] args) {
        String test = "{\"materialSpecIds\":\"1290237159690496,1290227934761216\",\"orgId\":\"1290082866483456\",\"orgId_Code\":\"TR01\",\"orgId_Name\":\"天润公司\",\"code\":\"0000-aa-0011\",\"name\":\"dadada\",\"manageClass\":1290226144481536,\"manageClass_Code\":\"12\",\"manageClass_Name\":\"test物料分类\",\"productTemplate\":1314591007133952,\"productTemplate_Name\":\"demo_1\",\"realProductAttribute\":1,\"realProductAttributeType\":1,\"unitUseType\":1,\"unit\":1290228462686464,\"unit_Name\":\"箱\",\"creator\":\"19484888888\",\"createDate\":\"2019-07-22 10:06:47\",\"createTime\":\"2019-07-22 10:06:47\",\"time\":{\"iControlTime\":false,\"ControlTimeType\":0,\"dateRange\":[null,null],\"id\":1319914827878657,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"productTags\":[],\"productAssistClasses\":[],\"productBarCodes\":[],\"defaultSKUOrderProperties\":[],\"productspecitems\":[{\"specValue\":\"Lee-S\",\"iSpecId\":1290406880596224,\"lsSpecItems_id\":1290406880596225,\"iOrder\":0,\"id\":1319914827895075,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"Lee-M\",\"iSpecId\":1290406880596224,\"lsSpecItems_id\":1290406880596226,\"iOrder\":1,\"id\":1319914827895076,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"S\",\"iSpecId\":1290237159690496,\"lsSpecItems_id\":1290237159690497,\"iOrder\":2,\"id\":1319914827895077,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"M\",\"iSpecId\":1290237159690496,\"lsSpecItems_id\":1290237159690498,\"iOrder\":3,\"id\":1319914827895078,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"L\",\"iSpecId\":1290237159690496,\"lsSpecItems_id\":1290237159690499,\"iOrder\":4,\"id\":1319914827895079,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"黑\",\"iSpecId\":1290227934761216,\"lsSpecItems_id\":1290227934761217,\"iOrder\":5,\"id\":1319914827895080,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"白\",\"iSpecId\":1290227934761216,\"lsSpecItems_id\":1290227934761218,\"iOrder\":6,\"id\":1319914827895081,\"productId\":1319914827878656,\"tenant\":1285997939314944},{\"specValue\":\"红\",\"iSpecId\":1290227934761216,\"lsSpecItems_id\":1290227934761219,\"iOrder\":7,\"id\":1319914827895082,\"productId\":1319914827878656,\"tenant\":1285997939314944}],\"productskus\":[{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895040,\"skuId\":1319914827878658,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"S\",\"freex2\":\"黑\",\"specIds\":\"1290406880596225;1290237159690497;1290227934761217\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):S;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"0\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827878658,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827878658,\"id\":1319914827976960,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827878658,\"id\":1319914827976961,\"tenant\":1285997939314944},{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827878658,\"id\":1319914827976962,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:黑\",\"code\":\"0000-aa-00110001\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895042,\"skuId\":1319914827895041,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"S\",\"freex2\":\"白\",\"specIds\":\"1290406880596225;1290237159690497;1290227934761218\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):S;zlf测试规格:白;\",\"isShow\":true,\"index\":\"1\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895041,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895041,\"id\":1319914828009728,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895041,\"id\":1319914828009729,\"tenant\":1285997939314944},{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895041,\"id\":1319914828009730,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:白\",\"code\":\"0000-aa-00110002\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895044,\"skuId\":1319914827895043,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"S\",\"freex2\":\"红\",\"specIds\":\"1290406880596225;1290237159690497;1290227934761219\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):S;zlf测试规格:红;\",\"isShow\":true,\"index\":\"2\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895043,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895043,\"id\":1319914828026112,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895043,\"id\":1319914828026113,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895043,\"id\":1319914828026114,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:红\",\"code\":\"0000-aa-00110003\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895046,\"skuId\":1319914827895045,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"M\",\"freex2\":\"黑\",\"specIds\":\"1290406880596225;1290237159690498;1290227934761217\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):M;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"3\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895045,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895045,\"id\":1319914828042496,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895045,\"id\":1319914828042497,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895045,\"id\":1319914828042498,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:黑\",\"code\":\"0000-aa-00110004\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895048,\"skuId\":1319914827895047,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"M\",\"freex2\":\"白\",\"specIds\":\"1290406880596225;1290237159690498;1290227934761218\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):M;zlf测试规格:白;\",\"isShow\":true,\"index\":\"4\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895047,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895047,\"id\":1319914828075264,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895047,\"id\":1319914828075265,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895047,\"id\":1319914828075266,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:白\",\"code\":\"0000-aa-00110005\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895050,\"skuId\":1319914827895049,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"M\",\"freex2\":\"红\",\"specIds\":\"1290406880596225;1290237159690498;1290227934761219\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):M;zlf测试规格:红;\",\"isShow\":true,\"index\":\"5\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895049,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895049,\"id\":1319914828091648,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895049,\"id\":1319914828091649,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895049,\"id\":1319914828091650,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:红\",\"code\":\"0000-aa-00110006\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895052,\"skuId\":1319914827895051,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"L\",\"freex2\":\"黑\",\"specIds\":\"1290406880596225;1290237159690499;1290227934761217\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):L;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"6\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895051,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895051,\"id\":1319914828108032,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895051,\"id\":1319914828108033,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895051,\"id\":1319914828108034,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:黑\",\"code\":\"0000-aa-00110007\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895054,\"skuId\":1319914827895053,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"L\",\"freex2\":\"白\",\"specIds\":\"1290406880596225;1290237159690499;1290227934761218\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):L;zlf测试规格:白;\",\"isShow\":true,\"index\":\"7\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895053,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895053,\"id\":1319914828140800,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895053,\"id\":1319914828140801,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895053,\"id\":1319914828140802,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:白\",\"code\":\"0000-aa-00110008\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895056,\"skuId\":1319914827895055,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-S\",\"free2\":\"L\",\"freex2\":\"红\",\"specIds\":\"1290406880596225;1290237159690499;1290227934761219\",\"specs\":\"Lee-尺码:Lee-S;txd尺码(单独显示):L;zlf测试规格:红;\",\"isShow\":true,\"index\":\"8\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895055,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895055,\"id\":1319914828157184,\"tenant\":1285997939314944},{\"specItemId\":1290406880596225,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895055,\"id\":1319914828157185,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895055,\"id\":1319914828157186,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-S;zlf测试规格:红\",\"code\":\"0000-aa-00110009\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895058,\"skuId\":1319914827895057,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"S\",\"freex2\":\"黑\",\"specIds\":\"1290406880596226;1290237159690497;1290227934761217\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):S;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"9\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895057,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895057,\"id\":1319914828189952,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895057,\"id\":1319914828189953,\"tenant\":1285997939314944},{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895057,\"id\":1319914828189954,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:黑\",\"code\":\"0000-aa-00110010\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895060,\"skuId\":1319914827895059,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"S\",\"freex2\":\"白\",\"specIds\":\"1290406880596226;1290237159690497;1290227934761218\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):S;zlf测试规格:白;\",\"isShow\":true,\"index\":\"10\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895059,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895059,\"id\":1319914828222720,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895059,\"id\":1319914828222721,\"tenant\":1285997939314944},{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895059,\"id\":1319914828222722,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:白\",\"code\":\"0000-aa-00110011\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895062,\"skuId\":1319914827895061,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"S\",\"freex2\":\"红\",\"specIds\":\"1290406880596226;1290237159690497;1290227934761219\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):S;zlf测试规格:红;\",\"isShow\":true,\"index\":\"11\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895061,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895061,\"id\":1319914828239104,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895061,\"id\":1319914828239105,\"tenant\":1285997939314944},{\"specItemId\":1290237159690497,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895061,\"id\":1319914828239106,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:红\",\"code\":\"0000-aa-00110012\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895064,\"skuId\":1319914827895063,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"M\",\"freex2\":\"黑\",\"specIds\":\"1290406880596226;1290237159690498;1290227934761217\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):M;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"12\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895063,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895063,\"id\":1319914828255488,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895063,\"id\":1319914828255489,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895063,\"id\":1319914828255490,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:黑\",\"code\":\"0000-aa-00110013\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895066,\"skuId\":1319914827895065,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"M\",\"freex2\":\"白\",\"specIds\":\"1290406880596226;1290237159690498;1290227934761218\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):M;zlf测试规格:白;\",\"isShow\":true,\"index\":\"13\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895065,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895065,\"id\":1319914828288256,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895065,\"id\":1319914828288257,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895065,\"id\":1319914828288258,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:白\",\"code\":\"0000-aa-00110014\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895068,\"skuId\":1319914827895067,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"M\",\"freex2\":\"红\",\"specIds\":\"1290406880596226;1290237159690498;1290227934761219\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):M;zlf测试规格:红;\",\"isShow\":true,\"index\":\"14\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895067,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895067,\"id\":1319914828304640,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895067,\"id\":1319914828304641,\"tenant\":1285997939314944},{\"specItemId\":1290237159690498,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895067,\"id\":1319914828304642,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:红\",\"code\":\"0000-aa-00110015\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895070,\"skuId\":1319914827895069,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"L\",\"freex2\":\"黑\",\"specIds\":\"1290406880596226;1290237159690499;1290227934761217\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):L;zlf测试规格:黑;\",\"isShow\":true,\"index\":\"15\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895069,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761217,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895069,\"id\":1319914828321024,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895069,\"id\":1319914828321025,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895069,\"id\":1319914828321026,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:黑\",\"code\":\"0000-aa-00110016\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895072,\"skuId\":1319914827895071,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"L\",\"freex2\":\"白\",\"specIds\":\"1290406880596226;1290237159690499;1290227934761218\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):L;zlf测试规格:白;\",\"isShow\":true,\"index\":\"16\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895071,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761218,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895071,\"id\":1319914828353792,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895071,\"id\":1319914828353793,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895071,\"id\":1319914828353794,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:白\",\"code\":\"0000-aa-00110017\",\"isSKU\":1,\"tenant\":1285997939314944},{\"productSKUDetail\":{\"stopstatus\":false,\"ustatus\":false,\"status\":false,\"saled\":false,\"mnemonicCode\":\"dadada\",\"shortName\":\"dadada\",\"id\":1319914827895074,\"skuId\":1319914827895073,\"productId\":1319914827878656,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},\"freex1\":\"Lee-M\",\"free2\":\"L\",\"freex2\":\"红\",\"specIds\":\"1290406880596226;1290237159690499;1290227934761219\",\"specs\":\"Lee-尺码:Lee-M;txd尺码(单独显示):L;zlf测试规格:红;\",\"isShow\":true,\"index\":\"17\",\"freeidx1\":1290406880596224,\"freeidx1_Name\":\"Lee-尺码\",\"freeidx2\":1290227934761216,\"freeidx2_Name\":\"zlf测试规格\",\"name\":\"dadada\",\"id\":1319914827895073,\"productId\":1319914827878656,\"productSKUSpecItems\":[{\"specItemId\":1290227934761219,\"specId\":1290227934761216,\"productId\":1319914827878656,\"skuId\":1319914827895073,\"id\":1319914828370176,\"tenant\":1285997939314944},{\"specItemId\":1290406880596226,\"specId\":1290406880596224,\"productId\":1319914827878656,\"skuId\":1319914827895073,\"id\":1319914828370177,\"tenant\":1285997939314944},{\"specItemId\":1290237159690499,\"specId\":1290237159690496,\"productId\":1319914827878656,\"skuId\":1319914827895073,\"id\":1319914828370178,\"tenant\":1285997939314944}],\"specNames\":\"Lee-尺码:Lee-M;zlf测试规格:红\",\"code\":\"0000-aa-00110018\",\"isSKU\":1,\"tenant\":1285997939314944}],\"productCheckFrees\":[],\"productParams\":[],\"productAlbums\":[],\"productAttachments\":[],\"productOrgs\":[],\"productCustomers\":[],\"productShops\":[],\"source\":0,\"id\":1319914827878656,\"productAssistUnits\":[{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911424,\"assistUnitType\":0,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911425,\"assistUnitType\":1,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911426,\"assistUnitType\":2,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911427,\"assistUnitType\":3,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911428,\"assistUnitType\":4,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911429,\"assistUnitType\":5,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944},{\"productId\":1319914827878656,\"mUnit\":1290228462686464,\"aUnit\":1290228462686464,\"id\":1319914827911430,\"assistUnitType\":6,\"productApplyRangeId\":1319914828435712,\"tenant\":1285997939314944}],\"hasSpecs\":true,\"creatorType\":1,\"platFormStaus\":1,\"productApplyRange\":[null],\"isStop\":false,\"isCreator\":true,\"productApplyRangeId\":1319914828435712,\"creatorId\":1285997939642624,\"tenant\":1285997939314944,\"isDeleted\":false,\"pubts\":\"2019-07-22 10:06:49\",\"detail!shortName\":\"dadada\",\"detail!mnemonicCode\":\"dadada\",\"detail!businessAttribute\":\"\",\"detail!saleChannel\":\"\",\"detail!purchaseUnit\":1290228462686464,\"detail!purchaseUnit_Name\":\"箱\",\"detail!stockUnit\":1290228462686464,\"detail!stockUnit_Name\":\"箱\",\"detail!batchPriceUnit\":1290228462686464,\"detail!batchPriceUnit_Name\":\"箱\",\"detail!batchUnit\":1290228462686464,\"detail!batchUnit_Name\":\"箱\",\"detail!onlineUnit\":1290228462686464,\"detail!onlineUnit_Name\":\"箱\",\"detail!offlineUnit\":1290228462686464,\"detail!offlineUnit_Name\":\"箱\",\"detail!requireUnit\":1290228462686464,\"detail!requireUnit_Name\":\"箱\",\"detail!isDisplayPrice\":true,\"detail!stopstatus\":false,\"detail!iStatus\":false,\"detail!iUOrderStatus\":false,\"detail!canSale\":true,\"detail!isBatchManage\":false,\"detail!isExpiryDateManage\":false,\"detail!isSerialNoManage\":false,\"detail!valueManageType\":0,\"detail!checkByCost\":false,\"detail!checkByBatch\":false,\"detail!isCheckFree\":0,\"detail!saleStyle\":\"1\",\"detail!enableSubscribe\":false,\"detail!enableDeposit\":false,\"detail!depositDealPayType\":0,\"detail!enablemodifyDeposit\":false,\"detail!depositPayType\":0,\"detail!serviceDurationUnit\":1,\"detail!canOrder\":false,\"detail!onlyOrder\":false,\"detail!orderAdvanceTime\":0,\"detail!iEnableCyclePurchase\":false,\"detail!isAllArea\":false,\"detail!iEnableEcontract\":false,\"detail!isRecommend\":false,\"detail!displayName\":\"dadada\",\"detail!allowStorePurchase\":true,\"detail!isSaleInOfflineStore\":true,\"detail!isPriceChangeAllowed\":false,\"detail!isOfflineStoreOrder\":true,\"detail!isOfflineStoreReturn\":true,\"detail!retailPriceDimension\":1,\"detail!isProcess\":false,\"detail!processType\":0,\"detail!isMaterial\":false,\"detail!isWeight\":false,\"detail!id\":1319914827878656,\"detail!productApplyRangeId\":1319914828435712,\"detail!saleChannelOfOnlineBatch\":false,\"detail!saleChannelOfOnlineRetail\":false,\"detail!saleChannelOfOfflineRetail\":false,\"detail!saleChannelOfDistribution\":false,\"detail!tenant\":1285997939314944}";
        Object object = JSONObject.toJSON(test);
        System.out.println(test);
        System.out.println(object.toString());

        String aa = "{\n" +
            "    \t\"materialSpecIds\":[\"1381068344152320\",\"1381068830544128\"],\n" +
            "        \"orgId\": \"1389317053403392\",\n" +
            "        \"id\": 1393509907960064,\n" +
            "        \"pubts\": \"2019-09-12 10:27:10\",\n" +
            "        \"code\": \"a002\",\n" +
            "        \"name\": \"材料a002\",\n" +
            "        \"manageClass\": 1392417797083392,\n" +
            "        \"productClass\": 1381066765635840,\n" +
            "        \"productTemplate\": 1389371013370112,\n" +
            "        \"platFormStaus\": 1,\n" +
            "        \"realProductAttribute\": 1,\n" +
            "        \"realProductAttributeType\": 1,\n" +
            "        \"unitUseType\": 2,\n" +
            "        \"unit\": 1381139365204224,\n" +
            "        \"dimensionCode\": \"http://u8c3-upmall.daily.app.yyuap.com/detail?goods_id=1393509907960064&wid=#!/detail?goods_id=1393509907960064\",\n" +
            "        \"time\": {\n" +
            "            \"id\": 1393509907960065,\n" +
            "            \"productId\": 1393509907960064,\n" +
            "            \"productApplyRangeId\": 1393509911367936,\n" +
            "            \"iControlTime\": false,\n" +
            "            \"ControlTimeType\": 0,\n" +
            "            \"dateRange\": [\n" +
            "                null,\n" +
            "                null\n" +
            "            ],\n" +
            "            \"tenant\": 1375529938522368\n" +
            "        },\n" +
            "        \"define\": {\n" +
            "            \"productId\": 1393509907960064,\n" +
            "            \"id\": 1393544834912512,\n" +
            "            \"tenant\": 1375529938522368\n" +
            "        },\n" +
            "        \"productBarCodes\": [],\n" +
            "        \"productspecitems\": [\n" +
            "            {\n" +
            "                \"specValue\": \"L\",\n" +
            "                \"iSpecId\": 1381068344152320,\n" +
            "                \"lsSpecItems_id\": 1381068344152321,\n" +
            "                \"iOrder\": 0,\n" +
            "                \"id\": 1393544828080388,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            },\n" +
            "            {\n" +
            "                \"specValue\": \"M \",\n" +
            "                \"iSpecId\": 1381068344152320,\n" +
            "                \"lsSpecItems_id\": 1381068344152322,\n" +
            "                \"iOrder\": 1,\n" +
            "                \"id\": 1393544828080389,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            },\n" +
            "            {\n" +
            "                \"specValue\": \"棉料\",\n" +
            "                \"iSpecId\": 1381068830544128,\n" +
            "                \"lsSpecItems_id\": 1381068830544129,\n" +
            "                \"iOrder\": 2,\n" +
            "                \"id\": 1393544828080390,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            },\n" +
            "            {\n" +
            "                \"specValue\": \"白\",\n" +
            "                \"iSpecId\": 1381067868066048,\n" +
            "                \"lsSpecItems_id\": 1381067868066049,\n" +
            "                \"iOrder\": 3,\n" +
            "                \"id\": 1393544828080391,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            }\n" +
            "        ],\n" +
            "        \"productskus\": [\n" +
            "            {\n" +
            "                \"productSKUDetail\": {\n" +
            "                    \"stopstatus\": false,\n" +
            "                    \"ustatus\": false,\n" +
            "                    \"status\": false,\n" +
            "                    \"batchPrice\": 0,\n" +
            "                    \"markPrice\": 0,\n" +
            "                    \"salePrice\": 0,\n" +
            "                    \"fMarketPrice\": 0,\n" +
            "                    \"fPrimeCosts\": 0,\n" +
            "                    \"saled\": false,\n" +
            "                    \"mnemonicCode\": \"CLa002\",\n" +
            "                    \"fLowestMarkPrice\": 0,\n" +
            "                    \"shortName\": \"材料a002\",\n" +
            "                    \"fNoTaxCostPrice\": 0,\n" +
            "                    \"id\": 1393544828080385,\n" +
            "                    \"skuId\": 1393544828080384,\n" +
            "                    \"productId\": 1393509907960064,\n" +
            "                    \"productApplyRangeId\": 1393509911367936,\n" +
            "                    \"tenant\": 1375529938522368\n" +
            "                },\n" +
            "                \"hasDefaultInit\": true,\n" +
            "                \"freex1\": \"L\",\n" +
            "                \"freex2\": \"棉料\",\n" +
            "                \"freex3\": \"白\",\n" +
            "                \"specIds\": \"1381068344152321;1381068830544129;1381067868066049\",\n" +
            "                \"specs\": \"尺码:L;材质:棉料;颜色:白;\",\n" +
            "                \"isShow\": true,\n" +
            "                \"index\": \"0\",\n" +
            "                \"freeidx1\": 1381068344152320,\n" +
            "                \"freeidx1_Name\": \"尺码\",\n" +
            "                \"freeidx2\": 1381068830544128,\n" +
            "                \"freeidx2_Name\": \"材质\",\n" +
            "                \"freeidx3\": 1381067868066048,\n" +
            "                \"freeidx3_Name\": \"颜色\",\n" +
            "                \"name\": \"材料a002\",\n" +
            "                \"id\": 1393544828080384,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"productSKUSpecItems\": [\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381067868066049,\n" +
            "                        \"specId\": 1381067868066048,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080384,\n" +
            "                        \"id\": 1393544828539136,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381068344152321,\n" +
            "                        \"specId\": 1381068344152320,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080384,\n" +
            "                        \"id\": 1393544828539137,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381068830544129,\n" +
            "                        \"specId\": 1381068830544128,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080384,\n" +
            "                        \"id\": 1393544828539138,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"specNames\": \"尺码:L;材质:棉料;颜色:白\",\n" +
            "                \"code\": \"a0020001\",\n" +
            "                \"isSKU\": 1,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            },\n" +
            "            {\n" +
            "                \"productSKUDetail\": {\n" +
            "                    \"stopstatus\": false,\n" +
            "                    \"ustatus\": false,\n" +
            "                    \"status\": false,\n" +
            "                    \"batchPrice\": 0,\n" +
            "                    \"markPrice\": 0,\n" +
            "                    \"salePrice\": 0,\n" +
            "                    \"fMarketPrice\": 0,\n" +
            "                    \"fPrimeCosts\": 0,\n" +
            "                    \"saled\": false,\n" +
            "                    \"mnemonicCode\": \"CLa002\",\n" +
            "                    \"fLowestMarkPrice\": 0,\n" +
            "                    \"shortName\": \"材料a002\",\n" +
            "                    \"fNoTaxCostPrice\": 0,\n" +
            "                    \"id\": 1393544828080387,\n" +
            "                    \"skuId\": 1393544828080386,\n" +
            "                    \"productId\": 1393509907960064,\n" +
            "                    \"productApplyRangeId\": 1393509911367936,\n" +
            "                    \"tenant\": 1375529938522368\n" +
            "                },\n" +
            "                \"hasDefaultInit\": true,\n" +
            "                \"freex1\": \"M \",\n" +
            "                \"freex2\": \"棉料\",\n" +
            "                \"freex3\": \"白\",\n" +
            "                \"specIds\": \"1381068344152322;1381068830544129;1381067868066049\",\n" +
            "                \"specs\": \"尺码:M ;材质:棉料;颜色:白;\",\n" +
            "                \"isShow\": true,\n" +
            "                \"index\": \"1\",\n" +
            "                \"freeidx1\": 1381068344152320,\n" +
            "                \"freeidx1_Name\": \"尺码\",\n" +
            "                \"freeidx2\": 1381068830544128,\n" +
            "                \"freeidx2_Name\": \"材质\",\n" +
            "                \"freeidx3\": 1381067868066048,\n" +
            "                \"freeidx3_Name\": \"颜色\",\n" +
            "                \"name\": \"材料a002\",\n" +
            "                \"id\": 1393544828080386,\n" +
            "                \"productId\": 1393509907960064,\n" +
            "                \"productSKUSpecItems\": [\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381067868066049,\n" +
            "                        \"specId\": 1381067868066048,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080386,\n" +
            "                        \"id\": 1393544828686592,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381068344152322,\n" +
            "                        \"specId\": 1381068344152320,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080386,\n" +
            "                        \"id\": 1393544828686593,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"specItemId\": 1381068830544129,\n" +
            "                        \"specId\": 1381068830544128,\n" +
            "                        \"productId\": 1393509907960064,\n" +
            "                        \"skuId\": 1393544828080386,\n" +
            "                        \"id\": 1393544828686594,\n" +
            "                        \"tenant\": 1375529938522368\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"specNames\": \"尺码:M ;材质:棉料;颜色:白\",\n" +
            "                \"code\": \"a0020002\",\n" +
            "                \"isSKU\": 1,\n" +
            "                \"tenant\": 1375529938522368\n" +
            "            }\n" +
            "        ],\n" +
            "        \"productApplyRangeId\": \"1393509911367936\",\n" +
            "        \"isCreator\": true,\n" +
            "        \"isApplied\": true,\n" +
            "        \"hasSpecs\": true,\n" +
            "        \"isStop\": false,\n" +
            "        \"modifier\": \"shixj3\",\n" +
            "        \"modifierId\": 1375529938768128,\n" +
            "        \"modifyTime\": \"2019-09-12 10:27:06\",\n" +
            "        \"modifyDate\": \"2019-09-12 10:27:06\",\n" +
            "        \"tenant\": 1375529938522368,\n" +
            "        \"detail!businessAttribute\": \"1,7,3\",\n" +
            "        \"detail!saleChannel\": \"1,2\",\n" +
            "        \"detail!productApplyRangeId\": 1393509911367936,\n" +
            "        \"detail!id\": 1393509907960064,\n" +
            "        \"detail!purchaseUnit\": 1381139365204224,\n" +
            "        \"detail!stockUnit\": 1381139365204224,\n" +
            "        \"detail!batchPriceUnit\": 1381139365204224,\n" +
            "        \"detail!batchUnit\": 1381139365204224,\n" +
            "        \"detail!onlineUnit\": 1381139365204224,\n" +
            "        \"detail!offlineUnit\": 1381139365204224,\n" +
            "        \"detail!requireUnit\": 1381139365204224,\n" +
            "        \"detail!isDisplayPrice\": true,\n" +
            "        \"detail!stopstatus\": false,\n" +
            "        \"detail!iStatus\": false,\n" +
            "        \"detail!iUOrderStatus\": false,\n" +
            "        \"detail!canSale\": true,\n" +
            "        \"detail!isBatchManage\": false,\n" +
            "        \"detail!isExpiryDateManage\": false,\n" +
            "        \"detail!isSerialNoManage\": false,\n" +
            "        \"detail!valueManageType\": 0,\n" +
            "        \"detail!checkByCost\": false,\n" +
            "        \"detail!checkByBatch\": false,\n" +
            "        \"detail!isCheckFree\": 0,\n" +
            "        \"detail!saleStyle\": \"1\",\n" +
            "        \"detail!enableSubscribe\": false,\n" +
            "        \"detail!enableDeposit\": false,\n" +
            "        \"detail!depositDealPayType\": 0,\n" +
            "        \"detail!enablemodifyDeposit\": false,\n" +
            "        \"detail!depositPayType\": 0,\n" +
            "        \"detail!serviceDurationUnit\": 1,\n" +
            "        \"detail!canOrder\": false,\n" +
            "        \"detail!onlyOrder\": false,\n" +
            "        \"detail!orderAdvanceTime\": 0,\n" +
            "        \"detail!iEnableCyclePurchase\": false,\n" +
            "        \"detail!isAllArea\": false,\n" +
            "        \"detail!iEnableEcontract\": false,\n" +
            "        \"detail!isRecommend\": false,\n" +
            "        \"detail!displayName\": \"材料a002\",\n" +
            "        \"detail!allowStorePurchase\": true,\n" +
            "        \"detail!isSaleInOfflineStore\": true,\n" +
            "        \"detail!isPriceChangeAllowed\": false,\n" +
            "        \"detail!isOfflineStoreOrder\": true,\n" +
            "        \"detail!isOfflineStoreReturn\": true,\n" +
            "        \"detail!retailPriceDimension\": 1,\n" +
            "        \"detail!isProcess\": false,\n" +
            "        \"detail!processType\": 0,\n" +
            "        \"detail!isMaterial\": false,\n" +
            "        \"detail!isWeight\": false,\n" +
            "        \"detail!saleChannelOfOnlineBatch\": true,\n" +
            "        \"detail!saleChannelOfOnlineRetail\": true,\n" +
            "        \"detail!saleChannelOfOfflineRetail\": false,\n" +
            "        \"detail!saleChannelOfDistribution\": false,\n" +
            "        \"detail!tenant\": 1375529938522368\n" +
            "    }";
    }
}
