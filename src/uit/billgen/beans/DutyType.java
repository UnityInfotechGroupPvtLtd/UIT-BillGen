package uit.billgen.beans;

public class DutyType
{
	private int hours 	= 	0;
	private int km		=	0;
	private double packageRate = 0;
	private String id = null;
	private String customerName = null;
	private String vehicleType  = null;
	private double extraKmRate = 0;
	
	private String dutyTypeString =null;
	private int uid = 0;
	private String acNonAcType;
	
	//public  static Map<String,DutyType>  map = new HashMap<String,DutyType>();
	
	
	/**
	 * @return the acNonAcType
	 */
	public String getAcNonAcType() {
		return acNonAcType;
	}
	/**
	 * @param acNonAcType the acNonAcType to set
	 */
	public void setAcNonAcType(String acNonAcType) {
		this.acNonAcType = acNonAcType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public double getPackageRate() {
		return packageRate;
	}
	public void setPackageRate(double packageRate) {
		this.packageRate = packageRate;
	}
	public DutyType(int uid, int hours, int km,double packageRate, double extraKmRate, String customerName, String vehicleType, String type)
	{
		this.setUid(uid);
		this.hours = hours;
		this.km = km;
		this.packageRate = packageRate;
		this.extraKmRate = extraKmRate;
		this.customerName = customerName;
		this.vehicleType = vehicleType;
		this.acNonAcType = type;
		
		this.id = this.vehicleType+"-"+String.valueOf(hours)+" Hrs "+String.valueOf(km)+" KM"+"-("+String.valueOf(customerName)+")";
		this.dutyTypeString = this.vehicleType+"-"+String.valueOf(hours)+" Hrs "+String.valueOf(km)+" KM"+"-("+String.valueOf(customerName)+")"+"_"+acNonAcType;
		//map.put(id, this);
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getDutyTypeString() {
		return dutyTypeString;
	}
	public void setDutyTypeString() {
		this.dutyTypeString = this.vehicleType+"-"+String.valueOf(hours)+" Hrs "+String.valueOf(km)+" KM"+"-("+String.valueOf(customerName.charAt(0))+")";
	}
	/*public DutyType getDutyType(String id)
	{
		return map.get(id);
		
	}*/
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}
	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void generateID()
	{
		this.dutyTypeString = this.vehicleType+"-"+String.valueOf(hours)+" Hrs "+String.valueOf(km)+" KM";
		this.id = this.vehicleType+"-"+String.valueOf(hours)+" Hrs "+String.valueOf(km)+" KM";
	}
	
	/**
	 * @return the extraKmRate
	 */
	public double getExtraKmRate() {
		return extraKmRate;
	}
	/**
	 * @param extraKmRate the extraKmRate to set
	 */
	public void setExtraKmRate(double extraKmRate) {
		this.extraKmRate = extraKmRate;
	}
	
}
