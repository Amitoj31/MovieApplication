import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appCheck]'
})
export class CheckDirective {

  constructor(private templateRef:TemplateRef<any>,private viewRef:ViewContainerRef) { }

  @Input() set appCheck(condition:boolean){
    if(condition){
      this.viewRef.createEmbeddedView(this.templateRef);
    } 
    else {
      this.viewRef.clear();
    }
  }

}
