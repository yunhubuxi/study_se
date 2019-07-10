package mybatis.onttomany;

import java.util.HashMap;

/**
 * 需求来源枚举
 *
 * @author u
 * @version 1.0
 */
public enum DemandSourceEnum {
	SALES_ORDER("销售订单", (short)0),
	FORECAST_ORDER("预测单", (short)1),
	SALES_FORECAST_ORDER("销售+预测单（不抵消）", (short)2),
	SALES_FORECAST_OFFSET("销售+预测单（抵消）", (short)3),
	ORDER_TEST("订单测试", (short)4);

	private String name;
	private short value;

	DemandSourceEnum(String name, short value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public short getValue() {
		return value;
	}

	private static HashMap<Short, DemandSourceEnum> map = null;

	private static synchronized void initMap() {
		if (map != null) {
			return;
		}
		map = new HashMap<Short, DemandSourceEnum>();
		DemandSourceEnum[] items = DemandSourceEnum.values();
		for (DemandSourceEnum item : items) {
			map.put(item.getValue(), item);
		}
	}

	public static DemandSourceEnum find(Number value) {
		if (value == null) {
			return null;
		}
		if (map == null) {
			initMap();
		}
		return map.get(value.shortValue());
	}
}
