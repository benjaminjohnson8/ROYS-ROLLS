package raysrentals.co.uk.lib.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Super class to hold all the audit fields.
 * @author MWalsh
 */
@MappedSuperclass
public abstract class ModelBase implements Serializable
{
	private static final long serialVersionUID = -3431636668445178381L;

	@Column(name = "created_by", updatable = false, nullable=false)
	@JsonIgnore
	private String createdBy;
	
	@Column(name = "created_date", updatable = false, nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@JsonIgnore
	private LocalDateTime createdDate;
	
	@Column(name = "last_updated_by", nullable=false)
	@JsonIgnore
	private String lastUpdatedBy;
	
	@Column(name = "last_updated_date", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@JsonIgnore
	private LocalDateTime lastUpdatedDate;
	
	public String getCreatedBy()
	{
		return createdBy;
	}
	protected void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate()
	{
		return createdDate;
	}
	protected void setCreatedDate(LocalDateTime createdDate)
	{
		this.createdDate = createdDate;
	}
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	protected void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public LocalDateTime getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}
	protected void setLastUpdatedDate(LocalDateTime lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}
}
