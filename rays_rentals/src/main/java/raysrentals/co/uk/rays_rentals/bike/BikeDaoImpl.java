package raysrentals.co.uk.rays_rentals.bike;

import org.springframework.stereotype.Repository;

import raysrentals.co.uk.lib.dao.HibernateJPABase;
@Repository
public class BikeDaoImpl extends HibernateJPABase<Bike, Long> implements BikeDao {

}
