import { useState } from "react";

import Modal from "./Modal";
import Backdrop from "./Backdrop";

function SaveContent() {
  const [modalIsOpen, setModal] = useState(false);

  function saveHandler() {
    console.log("clicked");
    setModal(true);
  }

  function closeModalHandler() {
    console.log("clickedd");
    setModal(false);
  }
  return (
    <div className="card">
      <h2>Type here</h2>
      <div>
        <label htmlFor="title">Текст</label>
        <input type = 'text' id= 'title'/>
      </div>
      <div className="actions">
        <button className="btn" onClick={saveHandler}>
          SAVE
        </button>
      </div>
      {modalIsOpen && (
        <Modal onCancel={closeModalHandler} onConfirm={closeModalHandler} />
      )}
      {modalIsOpen && <Backdrop onClick={closeModalHandler} />}
    </div>
  );
}

export default SaveContent;
