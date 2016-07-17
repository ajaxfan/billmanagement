Ext.define('OutTollCollectorReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    defaults:{ sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
        header: '序号',
    	width: 60
	}, {
        header: '票号',
        width: 160,
        dataIndex: 'billNo'
    }, {
        header: '应收卡',
        width: 75,
        dataIndex: 'receivableCard'
    }, {
        header: '实收卡',
        width: 70,
        dataIndex: 'receiveCard'
    }, {
        header: '闯关',
        width: 70,
        dataIndex: 'passCar'
    }, {
        header: '无卡',
        width: 70,
        dataIndex: 'noCard'
    }, {
        header: '欠费数',
        width: 70,
        dataIndex: 'arrears'
    }, {
        header: '金额',
        width: 70,
        dataIndex: 'totalFare'
    }, {
        header: '应交废票',
        width: 80,
        dataIndex: 'receivableInvalid'
    }, {
        header: '实交废票',
        width: 80,
        dataIndex: 'receiveInvalid'
    }, {
        header: '坏卡张数',
        width: 80,
        dataIndex: 'invalidCard'
    }, {
        header: '军车',
        width: 70,
        dataIndex: 'militaryVehicle'
    }, {
        header: '免费车',
        width: 70,
        dataIndex: 'freeCar'
    }, {
        header: 'U0',
        width: 70,
        dataIndex: 'ucrossCar'
    }, {
        header: '管理车',
        width: 70,
        dataIndex: 'manageCar'
    }, {
        header: '收割机',
        width: 70,
        dataIndex: 'harvester'
    }, {
        header: '紧急数',
        width: 80,
        dataIndex: 'urgentCar'
    }, {
        header: '张数',
        width: 80,
        dataIndex: 'billCount'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('OutTollCollectorReportModule.store.OutTollCollectorReport');
    	
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
    	   	        format: 'Y/m/d',
    	   	        editable: false,
    	   	        value: new Date()
            	}, {
                    text: '查询',
                    iconCls: 'search',
                    action: 'search',
	 	   		    listeners: {
		   			   click: function() {
		   				    var proxy = store.getProxy();
			   		        var beginDate = Ext.util.Format.date(Ext.getCmp("beginDate").getValue(), 'Y/m/d');
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
		   				    
		   				    applet.ppr("tollCollectorOutReport", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});