import createView from "../createView.js";

export default function PostIndex(props) {
    return `
                <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <form>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" type="text" placeholder="Enter Blog Title">
                    <div class="form-group">
                        <label for="content">Content</label>
                        <textarea class="form-control" id="content" rows="4" name="content" type="text"
                                  placeholder="Whats on your mind?"></textarea>
                    </div>

                    <div class="form-group row">
                        <button name="addPost" type="button" class="btn btn-primary">Add Post</button>
                    </div>
            </form>

            </div>
            <div class="post-container">
                ${props.posts.map(post => `
                <div>
                    <input class="edit-title" contentEditable="false" value="${post.title}">
                    <input class="edit-content" contentEditable="false" value="${post.content}">
                    <button class="edit-post-btn">Edit</button>
                    <button class="delete-post-btn">Delete</button>
                </div>
                `
    ).join('')}
            </div>
        </main>
    `;
}


function createPost() {
    $('#addPost').click(function() {
        let newPost = {
            title: $('#title').val(),
            content: $('#content').val(),
        }
    })
    let request = {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(post)
    }
    fetch("", request)
        .then((res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
            console.log(error);
            createView("/posts")
        }));
}

function editPost(){
    $('.edit-post-btn').click(function(){
        console.log("edit event fired off");

        $(this).siblings(".edit-title, .edit-content");
        $(this).text("Save");
    })
}

function deletePost(){

}
export function PostsEvent() {
//call function for create btn listener
    createPost();
    editPost();
    deletePost();
    //call function for edit btn listener
//call function for delete btn listener
}

