Ext.define('FreeCarReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    defaults:{ sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '小型车出口流量',
        width: 160,
        dataIndex: 'carOutCount'
    }, {
        header: '小型车出口免征金额',
        width: 140,
        dataIndex: 'carOutFare'
    }, {
        header: '其它客车出口流量',
        width: 160,
        dataIndex: 'ectOutCount'
    }, {
        header: '其它客车出口免征金额',
        width: 140,
        dataIndex: 'ectOutFare'
    }, {
        header: '货车出口流量',
        width: 160,
        dataIndex: 'truckOutCount'
    }, {
        header: '货车出口免征金额',
        width: 140,
        dataIndex: 'truckOutFare'
    }, {
        header: '绿色通道出口流量',
        width: 160,
        dataIndex: 'greenOutCount'
    }, {
        header: '绿色通道出口免征金额',
        width: 140,
        dataIndex: 'greenOutFare'
    }, {
        header: '闯关车出口流量',
        width: 160,
        dataIndex: 'passOutCount'
    }, {
        header: '闯关车出口免征金额',
        width: 140,
        dataIndex: 'passOutFare'
    }, {
        header: '小型车入口流量',
        width: 140,
        dataIndex: 'carInCount'
    }, {
        header: '小型车入口免征金额',
        width: 140,
        dataIndex: 'carInFare'
    }, {
        header: '小型车入口流量',
        width: 140,
        dataIndex: 'ectInCount'
    }, {
        header: '客车入口流量',
        width: 140,
        dataIndex: 'truckInCount'
    }, {
        header: '绿色通道入口流量',
        width: 140,
        dataIndex: 'greenInCount'
    }, {
        header: '闯关车入口流量',
        width: 140,
        dataIndex: 'passInCount'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('FreeCarReportModule.store.FreeCarReport');
    	
    	// Copy properties to Origin Object
    	Ext.apply(this, {
    		store: store,
    		tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
            		fieldLabel: '统计日期',
            		labelAlign: 'right',
            		width: 210,
            		labelWidth: 80,
    	           	id: 'beginDate',
    	   	        xtype: 'datefield',
    	   	        format: 'Y',
    	   	        editable: false,
    	   	        value: new Date()
            	}, {
                    text: '查询',
                    iconCls: 'search',
                    action: 'search',
	 	   		    listeners: {
		   			   click: function() {
		   				    var proxy = store.getProxy();
			   		        var beginDate = Ext.util.Format.date(Ext.getCmp("beginDate").getValue(), 'Y');
			   		        proxy.extraParams = store.baseParams || {};
			   		        proxy.extraParams["beginDate"] = beginDate;// 要统计的日期
			   		        
			   		        store.reload();
		   			   }
		   		    }
                }, '->', {
                    text: '打印报表',
      	   		    id: 'searchBtn',
                    iconCls: 'print',
                    action: 'del',
	 	   		    listeners: {
		   			   click: function() {
		   				    var applet = document.getElementById("reportApplet");
		   				    
		   				    applet.ppr("tollCollectorReportService", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});