package com.business;

import java.util.Date;

/**
 * vip信息类
 * @author bob yang
 *
 * @CopyRight yang
 */
public class VIPBean
{
  //会员卡编号
  private int cardID;
  
  //会员姓名
  private String name;
  
  //会员等级,0为一般会员，1为超级会员
  private  int VIPlevel;
  
  //会员手机号
  private String phonenumber;
  
  //该会员记录创建者
  private String creater;
  
  //创建时间
  private Date updatetime;

  public int getCardID()
  {
	  return cardID;
  }

  public void setCardID(int cardID)
  {
	  this.cardID = cardID;
  }

  public String getName()
  {
	  return name;
  }

  public void setName(String name)
  {
	  this.name = name;
  }

  public int getVIPlevel()
  {
	  return VIPlevel;
  }

  public void setVIPlevel(int vIPlevel)
  {
		VIPlevel = vIPlevel;
  }

  public String getPhonenumber()
  {
		return phonenumber;
  }

  public void setPhonenumber(String phonenumber)
  {
		this.phonenumber = phonenumber;
  }

  public String getCreater()
  {
		return creater;
  }

  public void setCreater(String creater)
  {
		this.creater = creater;
  }

  public Date getUpdatetime()
  {
		return updatetime;
  }

  public void setUpdatetime(Date updatetime)
  {
		this.updatetime = updatetime;
  }
  
}
