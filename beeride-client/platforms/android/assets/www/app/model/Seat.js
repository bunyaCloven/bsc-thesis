Ext.define('Beeride.model.Seat', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'name',
			type : 'string'
		} ]
	}
});