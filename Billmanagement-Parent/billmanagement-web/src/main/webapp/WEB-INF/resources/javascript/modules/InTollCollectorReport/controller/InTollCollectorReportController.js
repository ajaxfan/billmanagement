Ext.define('InTollCollectorReportModule.controller.InTollCollectorReportController', {
    extend: 'Ext.app.Controller',
    
    refs: [
        {ref: 'gridPanel', selector: 'gridpanel'},
        {ref: 'searchBtn', selector: 'gridPanel #searchBtn'}
    ],
    
    /**
     * Module Launch
     */
	onLaunch: function() {
		// 获得数据源对象
	    var gridPanel = this.getGridPanel(),
	         store = gridPanel.getStore();

	    // 设置焦点
        store.on("load", function(){
        	gridPanel.getSelectionModel().select(0);
        });
        store.load({
        	beginDate: Ext.util.Format.date(new Date(), 'Y/m/d')
        });
	}
});