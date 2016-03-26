Ext.define('Beeride.view.SearchToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'searchtoolbar',
	config : {
		items : [ {
			xtype : 'spacer'
		}, {
			iconCls : 'search',
			itemId : 'search',
			handler : function() {
				var toolbar = this.up('toolbar');
				var main = Ext.ComponentQuery.query('main')[0];
				main.add(Ext.create(toolbar.searchPage));
			}
		}, {
			xtype : 'spacer'
		} ]
	}
});