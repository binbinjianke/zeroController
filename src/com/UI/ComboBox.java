package com.UI;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboBox extends AbstractListModel<String> implements ComboBoxModel<String>
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String selecteditem = null;
	String[] dropDialog;
	
	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		return dropDialog.length;
	}

	@Override
	public String getElementAt(int index)
	{
		// TODO Auto-generated method stub
		return dropDialog[index];
	}

	@Override
	public Object getSelectedItem()
	{
		// TODO Auto-generated method stub
		return selecteditem;
	}

	@Override
	public void setSelectedItem(Object anItem)
	{
		// TODO Auto-generated method stub
		selecteditem = (String)anItem;
	}
   /**
    * 设置下拉数组
    * @param dropDialog
    */
	public void setDropGroup(String[] dropDialog)
	{
		// TODO Auto-generated method stub
		this.dropDialog = dropDialog;
	}
	/**
	 * 返回下拉数组
	 */
	public String[] getDropGroup()
	{
		// TODO Auto-generated method stub
		return dropDialog;
	}
}
