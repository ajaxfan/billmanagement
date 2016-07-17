Ext.define('MTCYearReportModule.view.GridPanel', {
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
        width: 80,
        dataIndex: 'employeeNo'
    }, {
        header: '人员名称',
        width: 80,
        dataIndex: 'employeeName'
    }, {
        header: '吉林费额',
        width: 80,
        dataIndex: 'jilinFare'
    }, {
        header: '内蒙费额',
        width: 80,
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
        width: 60,
        dataIndex: 'shortFare'
    }, {
        header: '长款',
        width: 60,
        dataIndex: 'longFare'
    }, {
        header: '欠费',
        width: 60,
        align: 'right',
        dataIndex: 'arrears'
    }, {
        header: '1型',
        width: 60,
        align: 'right',
        dataIndex: 'typeOne'
    }, {
        header: '2型',
        width: 60,
        align: 'right',
        dataIndex: 'typeTwo'
    }, {
        header: '3型',
        width: 60,
        align: 'right',
        dataIndex: 'typeThree'
    }, {
        header: '4型',
        width: 60,
        align: 'right',
        dataIndex: 'typeFour'
    }, {
        header: '5型',
        width: 60,
        align: 'right',
        dataIndex: 'typeFive'
    }, {
        header: '现金',
        width: 80,
        dataIndex: 'cash'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('MTCYearReportModule.store.MTCYearReport');
    	
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
		   				    
		   				    applet.ppr("mtcYearReport", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});