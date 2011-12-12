package com.sanisidro.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import com.sanisidro.to.UserTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class SearchCustomerMB 
{
	private String message;
	private String messageSuccess;
	private ArrayList<SelectItem> userTipes = new ArrayList<SelectItem>();
	private List<UserTO> customers = new ArrayList<UserTO>();
	private Long idCurrent;	
	
	// Paging.
	private int totalRows;
    private int firstRow;
    private int rowsPerPage;
    private int totalPages;
    private int pageRange;
    private Integer[] pages;
    private int currentPage;
    
    public String pageFirst() {
        page(0);
        return "";
    }

    public String pageNext() {
        page(firstRow + rowsPerPage);
        return "";
    }

    public String pagePrevious() {
        page(firstRow - rowsPerPage);
        return "";
    }
    
    public void page(ActionEvent event) {
        page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);        
    }

    public String pageLast() {
        page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
        return "";
    }
    
    private void page(int firstRow) {
        this.firstRow = firstRow;
        init(firstRow, rowsPerPage);
    }

	public ArrayList<SelectItem> getUserTipes() {
		return userTipes;
	}

	public void setUserTipes(ArrayList<SelectItem> userTipes) {
		this.userTipes = userTipes;
	}

	public Long getIdCurrent() {
		return idCurrent;
	}

	public void setIdCurrent(Long idCurrent) {
		this.idCurrent = idCurrent;
	}

	public SearchCustomerMB()
	{
		rowsPerPage = 10; 
        pageRange = 10;
        firstRow = 0;
		init(firstRow, rowsPerPage);
	}	
	public void init(int first, int maxResutl)
	{		
		customers = SanIsidroWrapper.getInstance().getAllCustomers(first, maxResutl);
		//TODO: TotalRows
		totalRows = 150;
		userTipes.clear();
		List<UserTypeTO> tos = SanIsidroWrapper.getInstance().getAllUserTypes();
		for (UserTypeTO u : tos)
		{
			userTipes.add(new SelectItem(u.getId(), u.getName()));
		}
	}
	
	public String editCustomer()
	{
		messageSuccess = "";
		for (UserTO to : customers)
		{
			if (to.getDni() == idCurrent)
			{
				to.setEditable(false);				
			}
			else if (!to.isEditable())
			{
				to.setEditable(true);
			}
		}
		return "";
	}
	
	public String updateCustomer()
	{	
		for (UserTO u : customers)
		{
			if (!u.isEditable())
			{
				try 
				{
					u = SanIsidroWrapper.getInstance().updateUser(u);
					u.setEditable(true);
					messageSuccess = "Actualización Exitosa";
					message = "";
					init(firstRow, rowsPerPage);
				} 
				catch (Exception e) 
				{
					message = e.getMessage();
				}
				break;				
			}
		}		
		return "";
	}
	
	public String getAllCustomers()
	{
		return "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UserTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<UserTO> customers) {
		this.customers = customers;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

	public Integer[] getPages() {
		return pages;
	}

	public void setPages(Integer[] pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}	
	
	
}
