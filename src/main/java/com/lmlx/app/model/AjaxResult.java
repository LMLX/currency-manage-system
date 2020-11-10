package com.lmlx.app.model;

import com.lmlx.app.constant.Constant;

public class AjaxResult {

	private Integer status;
	private String msg;
	private Object obj;

	public static boolean isSuccess(AjaxResult ajaxResult) {
		return Constant.AJAX_STATUS.success.equals(ajaxResult.getStatus());
	}

	/**
	 * 标记成功
	 *
	 * @return
	 */
	public static AjaxResult markSuccess() {
		AjaxResult mrv = new AjaxResult();
		mrv.setStatus(Constant.AJAX_STATUS.success);
		return mrv;
	}

	/**
	 * 标记成功
	 *
	 * @return
	 */
	public static AjaxResult markSuccess(Object obj) {
		AjaxResult mrv = new AjaxResult();
		mrv.setStatus(Constant.AJAX_STATUS.success);
		mrv.setObj(obj);
		return mrv;
	}

	/**
	 * 标记成功
	 *
	 * @return
	 */
	public static AjaxResult markSuccess(Object obj, String msg) {
		AjaxResult mrv = new AjaxResult();
		mrv.setStatus(Constant.AJAX_STATUS.success);
		mrv.setObj(obj);
		mrv.setMsg(msg);
		return mrv;
	}

	/**
	 * 标记失败
	 *
	 * @param msg
	 *
	 * @return
	 */
	public static AjaxResult markError(String msg) {
		AjaxResult mrv = new AjaxResult();
		mrv.setStatus(Constant.AJAX_STATUS.error);
		mrv.setMsg(msg);
		return mrv;
	}

	/**
	 * 标记失败
	 *
	 * @return
	 */
	public static AjaxResult markNoLogin() {
		AjaxResult mrv = new AjaxResult();
		mrv.setStatus(Constant.AJAX_STATUS.nologin);
		return mrv;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
