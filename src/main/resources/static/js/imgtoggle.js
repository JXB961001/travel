var k_iToggle=function(){
	var _this=this,
		_direct='crt';
		this.n=0;
		this.direct=function(s){
				if(typeof s==='string'){
					var u=$('#'+this.ids[2]);
						if(s=='lvl'){
							u.addClass(_this.iCls);
						}else{
							u.removeClass(_this.iCls);
							s='crt';
						}
					_direct=s;
				}
				clearTimeout(_this._auto);
				if(this.isAuto){this.auto();}
				return _direct;
			};
		this.isAuto=false;
		this.init=function(o){
				if(o.boxId&&o.numId&&o.imgId){
					_this.ids=[o.boxId,o.numId,o.imgId];
				}else{
					alert('ȱ��ID');return;
				}
				this.isAuto=!!o.isAuto;
				this.aCls=''+o.aCls;
				this.iCls=''+o.iCls
				this.evtNum();
				this.direct(o.direct);
			}
		this.evtNum=function(){
				var ls=$('#'+_this.ids[1]+' li');
				this.numLen=ls.length;
				ls.each(function(i,o){
					var t=_this.isAuto;
					$(this).hover(function(){
							$(ls[_this.n]).removeClass(_this.aCls);
							$(this).addClass(_this.aCls);
							_this.n=i;
							_this.isAuto=false;
							clearTimeout(_this._auto);
							_this.run();						
					},
					function(){
						_this.isAuto=t;
						_this.auto();
					});	
				});
			}
		this.Tween=function(t,b,c,d){
				return c*((t=t/d-1)*t*t + 1) + b;
			}
		this.auto=function(){
				if(this.isAuto){
					clearTimeout(this._auto);
					this._auto=setTimeout(function(){
						var o=$('#'+_this.ids[1]+' li');
						o.eq(_this.n).removeClass(_this.aCls);
						if(_this.n<_this.numLen-1){_this.n++;}else{_this.n=0;}
						o.eq(_this.n).addClass(_this.aCls);
						_this.run();
					},2000);
				}
			}
		this.run=function(){
			var _demo=$('#'+_this.ids[0])[0],
			sn=this.direct()=='crt'?_demo.scrollTop:_demo.scrollLeft,
			sl=this.direct()=='crt'?_demo.scrollHeight:_demo.scrollWidth,
			sc=parseInt(sl*1*this.n/this.numLen)-sn,
			t=0,b=sn,c=sc,d=60;
			clearTimeout(_this._t);
			(function _move(){
				if(t<d){
					t++;
					if(_this.direct()=='crt'){
						_demo.scrollTop=_this.Tween(t,b,c,d);
					}else{
						_demo.scrollLeft=_this.Tween(t,b,c,d);
					}
					_this._t=setTimeout(_move,10);
				}else{
					_this.auto();
				}
			})();
		}
}
