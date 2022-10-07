package com.kurdistan.instagram.modules.post;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mappings({
            @Mapping(source = "location",target = "location",qualifiedByName = "locationDTOToLocation")

    })
    Post toPost(PostDTO postDTO);

    @Mappings({
            @Mapping(source = "location",target = "location",qualifiedByName = "locationToLocationDTO")

    })
    PostDTO toPostDTO(Post post);

    List<Post> toListPost(List<PostDTO> postDTOS);
    List<PostDTO> toListPostDTO(List<Post> posts);

    @Named("locationDTOToLocation")
    default Point<G2D> convertLocationDTOToLocation(LocationDTO locationDTO){
        return  Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
    }

    @Named("locationToLocationDTO")
    default LocationDTO convertLocationToLocationDTO(Point<G2D> point) {
        G2D g2D=point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return locationDTO;
    }
}
