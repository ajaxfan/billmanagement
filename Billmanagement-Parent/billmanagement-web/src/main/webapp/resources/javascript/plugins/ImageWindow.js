Ext.define('Ext.plugins.ImageWindow', {
	extend: 'Ext.window.Window',
	alias: 'widget.imagewindow',
	
	title: '车辆快照 (仅能查询到最近一个月内的)',
    iconCls: 'feed-icon',
    resizable: false,
    modal: true,
    width: 420,
    height: 420,
    autoScroll: true,
    closeAction: 'close',
    layout: 'fit'
});