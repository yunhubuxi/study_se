package excel;

import org.junit.Assert;
import org.junit.Test;

public class ExcelTest {
    private ExcelToolsService service;

    @Test
    public void testMacro() {
        try {
            String path = "C:/Users/admin.admin-PC.000/Desktop/vb/合并的模板/合同模板.xlsm";
            service = new ExcelToolsService();
            service.execMacro(path, "文本替换.生成文档");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
