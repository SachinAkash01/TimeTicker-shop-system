
package Code;


public class InvoiceCode {
    private int CusNIC;
    private String cusname;
    private String Brand;
    private String Color;
    private String SNum;
    private String PaymentMethod;
    private String WatchType;

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public String getWatchType() {
        return WatchType;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public void setWatchType(String WatchType) {
        this.WatchType = WatchType;
    }


    
    public int getCusNIC() {
        return CusNIC;
    }

    public String getCusname() {
        return cusname;
    }

    public String getBrand() {
        return Brand;
    }

    public String getColor() {
        return Color;
    }

    public String getSNum() {
        return SNum;
    }

    public void setCusNIC(int CusNIC) {
        this.CusNIC = CusNIC;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setSNum(String SNum) {
        this.SNum = SNum;
    }
    
}
