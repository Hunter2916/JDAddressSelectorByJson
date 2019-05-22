package chihane.jdaddressselector;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;
import chihane.jdaddressselector.utils.JsonParserUtils;

public class DefaultAddressProvider implements AddressProvider {
    private List<Province> provinceList;
    private List<City> cityList = null;
    private List<County> districtList = null;
    private List<Street> townList = null;

    public DefaultAddressProvider(Context mContext) {
        provinceList = JsonParserUtils.readFromAssets(mContext);

    }

    /**
     * 省
     *
     * @param addressReceiver
     */
    @Override
    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {
        if (provinceList != null) {
            addressReceiver.send(new ArrayList<>(provinceList));
        }
    }

    /**
     * 市
     *
     * @param provinceId
     * @param addressReceiver
     */
    @Override
    public void provideCitiesWith(int provinceId, final AddressReceiver<City> addressReceiver) {
        for (int i = 0; i < provinceList.size(); i++) {
            if (provinceList.get(i).getId().equals(String.valueOf(provinceId)) && provinceList != null) {
                cityList = provinceList.get(i).getChildren();
            }
        }
        addressReceiver.send(new ArrayList<>(cityList));
    }

    /**
     * 区
     *
     * @param cityId
     * @param addressReceiver
     */
    @Override
    public void provideCountiesWith(int cityId, final AddressReceiver<County> addressReceiver) {
        for (int i = 0; i < cityList.size(); i++) {
            if (cityList.get(i).getId().equals(String.valueOf(cityId)) && cityList != null) {
                districtList = cityList.get(i).getChildren();
            }
        }
        addressReceiver.send(new ArrayList<>(districtList));
    }

    /**
     * 乡镇
     *
     * @param countyId
     * @param addressReceiver
     */
    @Override
    public void provideStreetsWith(int countyId, final AddressReceiver<Street> addressReceiver) {
        for (int i = 0; i < districtList.size(); i++) {
            if (districtList.get(i).getId().equals(String.valueOf(countyId)) && districtList != null) {
                townList = districtList.get(i).getChildren();
            }
        }
        addressReceiver.send(new ArrayList<>(townList));
    }
}
