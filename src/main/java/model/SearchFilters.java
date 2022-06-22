package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="filterDataRozetka")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchFilters {

    @XmlElement(name = "searchFiltersRozetka")
    private List<SearchFilter> searchFilterList;

    public List<SearchFilter> getSearchFilterList() { return searchFilterList; }
}
