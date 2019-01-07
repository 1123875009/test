package cn.itcast.itcaststore.domain;

public class OrderItem {//订单条目，相当于订单的一类商品项

	private Order order;//属于哪个订单
	private Product p;//买了哪个商品
	private int buynum;//购买的数量

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

}
