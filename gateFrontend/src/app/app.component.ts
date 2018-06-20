import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'sgc-root',
  template: `
    <div id="wallpaper" [style.backgroundImage]="'url(' + getImageUrl(state) + ')'">
    
    </div>
  `,
  styles: [`
  #wallpaper {
      width: 100%;
      height: 100%;
      background-repeat: no-repeat;
      background-position: center center;
      
  }
  `]
})
export class AppComponent implements OnInit {
    public state: any = {};

    constructor(private http: HttpClient) {

    }

    getImageUrl(state) {
        const base = '/assets/';
        if (state.irisState === 'CLOSE') {
            return base + 'stargate-iris.png';
        } else if (state.stargateState === 'OPEN') {
            return base + 'stargate-open.jpg';
        } else {
            return base + 'stargate.jpg';
        }
    }

    getGateState() {
        return this.http.get(`/api/star-gate/state`);
    }

    ngOnInit(): void {
        setInterval(() => {
            this.getGateState().subscribe(state => this.state = state)
        }, 1000)
    }
}
