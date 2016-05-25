package com.mycompany.manish;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class ImmutableClass {

	private final Integer x;
	private final String y;
	private final List<String> list;//Extra Care
	private final Map<String, String> map;//Extra Care
	private final boolean flag;
	private final Boolean flag2;
	private final Date date;//Extra Care
	private final float z;
	private final Float abc;
	private final long labc;

	
	
	
	/**
	 * @param x
	 * @param y
	 * @param list
	 * @param map
	 * @param flag
	 * @param flag2
	 * @param date
	 * @param z
	 * @param abc
	 */
	private ImmutableClass(Integer x, String y, List<String> list,
			Map<String, String> map, boolean flag, Boolean flag2, Date date,
			float z, Float abc, long labc) {
		super();
		this.x = x;
		this.y = y;
		this.list = list;
		this.map = map;
		this.flag = flag;
		this.flag2 = flag2;
		this.date = new Date(date.getTime());
		this.z = z;
		this.abc = abc;
		this.labc = labc;
		
	}

	public ImmutableClass createInstance(Integer x, String y, List<String> list,
			Map<String, String> map, boolean flag, Boolean flag2, Date date,
			float z, Float abc, long labc){
		return new ImmutableClass(x, y, list, map, flag, flag2, date, z, abc,labc);
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return Collections.unmodifiableList(list);
	}

	/**
	 * @return the map
	 */
	public Map<String, String> getMap() {
		return Collections.unmodifiableMap(map);
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @return the flag2
	 */
	public Boolean getFlag2() {
		return flag2;
	}

	/**
 	 Date class is mutable so we need a little care here.
	 We should not return the reference of original instance variable.
 	 Instead a new Date object, with content copied to it, should be returned.
	 * @return the date
	 */
	public Date getDate() {
		return new Date(date.getTime());
	}

	/**
	 * @return the z
	 */
	public float getZ() {
		return z;
	}

	/**
	 * @return the abc
	 */
	public Float getAbc() {
		return abc;
	}
	
	
	private int testHashcode(){
		final int prime = 31;
		int result = 1;
		result = prime*result +( (x==null)?0:this.x.hashCode());
		result = prime*result +( (y==null)?0:this.y.hashCode()); //int
		result = prime*result +( (date==null)?0:this.date.hashCode()); //date
		result = prime*result +( (list==null)?0:this.list.hashCode()); //list
		result = prime*result +( Float.floatToIntBits(z)); //float
		result = prime*result +( (abc==null)?0:this.abc.hashCode()); //Float
		result = prime*result +( int )(labc ^ (labc >>> 32)); //long
		result = prime*result +(flag==true?1:0); //boolean
		//If the field f is a double: calculate 
		//Double.doubleToLongBits(f) and handle the return value like every long value
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abc == null) ? 0 : abc.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + ((flag2 == null) ? 0 : flag2.hashCode());
		result = prime * result + (int) (labc ^ (labc >>> 32));
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}
	
	private boolean testEqual(Object obj){
		if(obj==null)
			return false;
		if(obj==this)
			return true;
		if(getClass()!=obj.getClass())
			return false;

		ImmutableClass otherClass = (ImmutableClass)obj;
		if(abc ==null){
			if(otherClass.abc!=null)
				return false;
		}
		else if (!abc.equals(otherClass.abc))
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImmutableClass other = (ImmutableClass) obj;
		if (abc == null) {
			if (other.abc != null)
				return false;
		} else if (!abc.equals(other.abc))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (flag != other.flag)
			return false;
		if (flag2 == null) {
			if (other.flag2 != null)
				return false;
		} else if (!flag2.equals(other.flag2))
			return false;
		if (labc != other.labc)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}

		
	
}
