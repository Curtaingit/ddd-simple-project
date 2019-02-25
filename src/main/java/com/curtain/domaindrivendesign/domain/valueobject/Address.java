package com.curtain.domaindrivendesign.domain.valueobject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Curtain
 * @date 2018/12/18 8:27
 */

@Embeddable
public class Address implements Serializable{

    /** 城市 */
    private String city;

    /** 省份 */
    private String province;

    /** 国家 */
    private String country;

    /** Necessary for attributes of JPA entities internally. */
    private Address() {

    }

    public Address(String city, String province, String country) {
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public void setCity(String city) {
        if (city != null && !("".equals(city))) {
            this.city = city;
        }
        //todo throw   参数错误。  city...

    }

    public void setProvince(String province) {
        if (province != null && !("".equals(province))) {
            this.province = province;
        }
        //todo throw   参数错误。  province...
    }

    public void setCountry(String country) {
        if (country != null && !("".equals(country))) {
            this.country = country;
        }
        //todo throw   参数错误。  country...

    }

    public String getCity() {

        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }
}
