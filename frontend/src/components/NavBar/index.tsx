import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import "./styles.css";
function Navbar() {
    return (
        <header>
      <nav className="container">
        <div className='movierate-nav-content'>
          <h1 style={{margin:0}}>MovieRate</h1>
          <a href="https://github.com/felipematheus1337">
          <div className="movierate-contact-container">
            <GithubIcon/>
            <p style={{margin:'0 0 0 10px'}}>/felipematheus1337</p>
          </div>
          </a>
        </div>
      </nav>
    </header>
    )
}

export default Navbar;