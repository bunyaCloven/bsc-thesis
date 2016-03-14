Ext.define('Beeride.util.Ajax', {
	singleton : true,
	load : function(form, url) {
		Ext.Ajax.request({
			url : url,
			params : {
				username : Beeride.util.Auth.getUsername()
			},
			success : function(response) {
				var data = JSON.parse(response.responseText);
				for ( var x in data.data) {
					var field = form.down('[name=' + x + ']');
					if (field) {
						if (field.xtype === 'datetimepickerfield') {
							field.setValue(new Date(data.data[x]));
						} else if (field.xtype === 'label') {
							field.setHtml(field.getHtml() + data.data[x]);
						} else {
							field.setValue(data.data[x]);
						}
					}
				}
			}
		});
	}
});