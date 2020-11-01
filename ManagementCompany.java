/*
 * PROGRAMMER: ALAN DUONG
 */
public class ManagementCompany {
	private String name;
	private String taxID;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	
	public ManagementCompany(){
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0,10,10);
	}
	public ManagementCompany(String name, String taxID, double mgmFee){
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		this.name = name;
		this.taxID = taxID;
		this. mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x,y,width,depth);
	}
	public ManagementCompany(ManagementCompany otherCompany){
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = otherCompany.plot;
        this.properties = otherCompany.properties;
	}
	public int getMAX_PROPERTY(){
        return  MAX_PROPERTY;
    }
	public int addProperty(Property property){
        if (property == null){
            return -2;
        }
        else if (!plot.encompasses(property.getPlot())){
            return -3;
        }

        for (int i = 0; i < properties.length; i++){
            if (properties[i] != null){
                if (properties[i].getPlot().overlaps(property.getPlot())){
                    return -4;
                }
            }
            else{
                properties[i] = property;
                return i;
            }
        }
        return -1;
	}
	public int addProperty(String name,String city,double rent,String owner){
		return addProperty(new Property(name,city,rent,owner));
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth){
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }
	public double totalRent(){
		double totalRent = 0.0;
		for(Property property : properties){
            if (property == null){
                break;
            }
			 totalRent += property.getRentAmount();
		}
		return totalRent;
	}
	public double maxRentProp(){
		double maxRentProp = 0.0;
		for(Property property : properties){
			if(property == null){
				break;
			}
			if(maxRentProp < property.getRentAmount()){
				maxRentProp = property.getRentAmount();
			}
		}
		return maxRentProp;
	}
	public int maxRentPropertyIndex(){
		int index = -1;
		double maxRentPropI = 0.0;
		for (int i = 0; i < properties.length; i++){
			if(properties[i] == null){
				break;
			}
			if(maxRentPropI < properties[i].getRentAmount()){
				maxRentPropI = properties[i].getRentAmount();
				index = i;
			}
		}
		return index;
	}
	public String displayPropertyAtIndex(int i){
        String displayProperty;
        displayProperty = properties[i].toString();
        return displayProperty;
    }
	public String toString(){
		String j = "";
		j += "List of the properties for " + name + ", taxID: " + taxID + "\n";
		j += "__________________________________________________________________________\n";
		for (Property property : properties){
			if(property == null){
				break;
			}
			j += property.toString();
			j += "\n";
		}
		j += "__________________________________________________________________________\n";
		j += "total management Fee: " + (totalRent() * mgmFee / 100);
		return j;
	}
	public String getName() {
		return name;
	}
	public Plot getPlot() {
		return new Plot(plot);
	}
}
