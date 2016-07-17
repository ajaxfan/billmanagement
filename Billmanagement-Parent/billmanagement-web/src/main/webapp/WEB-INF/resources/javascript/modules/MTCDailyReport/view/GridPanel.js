Ext.define('MTCDailyReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    defaults:{ sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '人员编号',
        width: 160,
        dataIndex: 'employeeNo'
    }, {
        header: '人员名称',
        width: 140,
        dataIndex: 'employeeName'
    }, {
        header: '吉林费额',
        width: 160,
        dataIndex: 'jilinFare'
    }, {
        header: '内蒙费额',
        width: 140,
        dataIndex: 'neimengFare'
    }, {
        header: '应收费额',
        width: 80,
        dataIndex: 'receivableFare'
    }, {
        header: '实收费额',
        width: 80,
        dataIndex: 'receivedFare'
    }, {
        header: '短款',
        width: 80,
        dataIndex: 'shortFare'
    }, {
        header: '长款',
        width: 90,
        dataIndex: 'longFare'
    }, {
        header: '欠费',
        width: 90,
        align: 'right',
        dataIndex: 'arrears'
    }, {
        header: '1型',
        width: 90,
        align: 'right',
        dataIndex: 'typeOne'
    }, {
        header: '2型',
        width: 90,
        align: 'right',
        dataIndex: 'typeTwo'
    }, {
        header: '3型',
        width: 90,
        align: 'right',
        dataIndex: 'typeThree'
    }, {
        header: '4型',
        width: 90,
        align: 'right',
        dataIndex: 'typeFour'
    }, {
        header: '5型',
        width: 90,
        align: 'right',
        dataIndex: 'typeFive'
    }, {
        header: 'cash',
        width: 100,
        dataIndex: 'cash'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('MTCDailyReportModule.store.MTCDailyReport');
    	
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
		   				    
		   				    applet.ppr("mtcDailyReport", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});